package prep.SpringBootApplication_1.responses;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Dtos {
    public static class GenerateRequest {
        @NotBlank
        public String text;
        @Min(1)
        public int maxScans = 3; // default 3
    }

    public static class GenerateResponse {
        public String qrId;
        public String url;      // put this into your QR as value
        public int scansLeft;
        public int maxScans;

        public GenerateResponse(String qrId, String url, int scansLeft, int maxScans) {
            this.qrId = qrId;
            this.url = url;
            this.scansLeft = scansLeft;
            this.maxScans = maxScans;
        }
    }

    public static class ScanEvent {
        public String qrId;
        public int scans;
        public int maxScans;
        public boolean expired;

        public ScanEvent(String qrId, int scans, int maxScans, boolean expired) {
            this.qrId = qrId;
            this.scans = scans;
            this.maxScans = maxScans;
            this.expired = expired;
        }
    }
}
