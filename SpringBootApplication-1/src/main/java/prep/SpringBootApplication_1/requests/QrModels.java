package prep.SpringBootApplication_1.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class QrModels {
    public static class QrEntry {
        public final String id;
        public final String text;
        public final int maxScans;
        public volatile int scans;
        public final Instant createdAt;

        public QrEntry(String text, int maxScans) {
            this.id = UUID.randomUUID().toString();
            this.text = text;
            this.maxScans = maxScans;
            this.scans = 0;
            this.createdAt = Instant.now();
        }

        public boolean isExpired() {
            return scans >= maxScans;
        }

        public int scansLeft() {
            return Math.max(0, maxScans - scans);
        }
    }

    // In-memory store (replace with DB in production)
    public static class QrStore {
        public static final ConcurrentHashMap<String, QrEntry> MAP = new ConcurrentHashMap<>();
    }

}
