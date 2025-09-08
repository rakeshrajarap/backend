package prep.SpringBootApplication_1.controller;

import org.springframework.http.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import prep.SpringBootApplication_1.requests.QrModels;
import prep.SpringBootApplication_1.responses.Dtos;

@RestController
@RequestMapping("/api/qr")
public class QrController {

    private final SimpMessagingTemplate messaging;

    public QrController(SimpMessagingTemplate messaging) {
        this.messaging = messaging;
    }

    /**
     * Create a QR with text + maxScans (default 3).
     * Returns a URL that you will encode into the QR image.
     */
    @PostMapping("/generate")
    public Dtos.GenerateResponse generate(@Validated @RequestBody Dtos.GenerateRequest req) {
        QrModels.QrEntry entry = new QrModels.QrEntry(req.text, req.maxScans);
        QrModels.QrStore.MAP.put(entry.id, entry);

        String url = "http://localhost:8080/api/qr/scan/" + entry.id;
        return new Dtos.GenerateResponse(entry.id, url, entry.scansLeft(), entry.maxScans);
    }

    /**
     * This endpoint is what opens when someone scans the QR.
     * It increments count, sends a WebSocket event, and returns the text
     * (or "expired" message). Using text/plain so scanners show raw text.
     */
    @GetMapping(value = "/scan/{qrId}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> scan(@PathVariable String qrId) {
        QrModels.QrEntry entry = QrModels.QrStore.MAP.get(qrId);
        if (entry == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid QR");
        }

        // already expired
        if (entry.isExpired()) {
            messaging.convertAndSend("/topic/qr/" + qrId,
                    new Dtos.ScanEvent(qrId, entry.scans, entry.maxScans, true));
            return ResponseEntity.status(HttpStatus.GONE).body("QR Expired");
        }

        // increment and notify
        entry.scans++;
        boolean nowExpired = entry.isExpired();
        messaging.convertAndSend("/topic/qr/" + qrId,
                new Dtos.ScanEvent(qrId, entry.scans, entry.maxScans, nowExpired));

        // return the original text so the scanner shows it
        return ResponseEntity.ok(entry.text);
    }
}