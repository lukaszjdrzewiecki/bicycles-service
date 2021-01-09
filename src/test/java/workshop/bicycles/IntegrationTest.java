package workshop.bicycles;

import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.nio.charset.StandardCharsets;

public class IntegrationTest {

    @SneakyThrows
    protected byte[] resourceAsBytes(String path) {
        return FileCopyUtils.copyToByteArray(new ClassPathResource(path).getInputStream());
    }

    @SneakyThrows
    protected String resourceAsJson(String path) {
        byte[] bytes = resourceAsBytes(path);
        return new String(bytes, StandardCharsets.UTF_8);
    }


}
