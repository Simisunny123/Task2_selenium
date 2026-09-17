package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        String fileName =
                testName + "_" + timestamp + ".png";

        Path destination = Paths.get(
                "screenshots",
                fileName
        );

        try {

            Files.createDirectories(
                    destination.getParent()
            );

            File source =
                    ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Files.copy(
                    source.toPath(),
                    destination
            );

            return destination.toString();

        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }
    }
}