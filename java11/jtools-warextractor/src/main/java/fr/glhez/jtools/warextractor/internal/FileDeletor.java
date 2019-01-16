package fr.glhez.jtools.warextractor.internal;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FileDeletor implements FileVisitor<Path> {

  @Override
  public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs) throws IOException {
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
    Files.delete(file);
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult visitFileFailed(final Path file, final IOException exc) throws IOException {
    throw new IOException("Could not delete file [" + file + "]", exc); // rethrow
  }

  @Override
  public FileVisitResult postVisitDirectory(final Path dir, final IOException exc) throws IOException {
    if (null != exc) {
      throw exc;
    }
    return FileVisitResult.CONTINUE;
  }

}
