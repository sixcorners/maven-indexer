package org.apache.maven.index.reader.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import org.apache.maven.index.reader.WritableResourceHandler.WritableResource;

public class PathWritableResource implements WritableResource {
  private final Path path;

  public PathWritableResource(Path path) {
    this.path = path;
  }

  @Override
  public OutputStream write() throws IOException {
    return Files.newOutputStream(path);
  }

  @Override
  public InputStream read() throws IOException {
    try {
      return Files.newInputStream(path);
    } catch (NoSuchFileException e) {
      return null;
    }
  }

  @Override
  public void close() throws IOException {}
}
