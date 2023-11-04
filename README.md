import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        // Process the uploaded file
        // You can save the file, perform operations, etc.
        // In this example, just returning a success message
        return ResponseEntity.ok("File uploaded successfully: " + file.getOriginalFilename());
    }
}
