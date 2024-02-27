package com.github.daimLiat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DockerCommandRunner {
    public static void main(String[] args) {
        try {
            // Create ProcessBuilder for the Docker command
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("docker", "run", "--rm", "hello-world");

            // Start the process
            Process process = processBuilder.start();

            // Read the output of the process
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();
            System.out.println("Docker command execution finished with exit code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
