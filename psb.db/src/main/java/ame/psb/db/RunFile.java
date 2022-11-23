package ame.psb.db;

import ame.psb.commons.compress.GZIPCompressor;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

public class RunFile {

  private String id;

  private String fileName;

  private byte[] binary;

  private String comments;

  private String updatedUser;

  private Date updatedTime;


  public RunFile() {
    this.id = UUID.randomUUID().toString();
  }

  public RunFile(RunFile data) {
    this.id = data.id;
    this.fileName = data.fileName;
    this.binary = data.binary;
    this.comments = data.comments;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public RunFile clone() {
    return new RunFile(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public byte[] getBinary() {
    return binary;
  }

  public void setBinary(byte[] binary) {
    this.binary = binary;
  }

  public void setBinaryAndDecompress(byte[] binary) throws SQLException {
    if (GZIPCompressor.isGZIP(binary)) {
      try {
        this.binary = new GZIPCompressor().decompress(binary);
      } catch (IOException e) {
        throw new SQLException("GZIP文件解压缩失败: " + fileName);
      }
    } else {
      this.binary = binary;
    }
  }

  public byte[] getCompressedBinary() throws SQLException {
    try {
      return !GZIPCompressor.isGZIP(binary) ? new GZIPCompressor().compress(binary) : binary;
    } catch (IOException e) {
      throw new SQLException("文件压缩GZIP失败: " + fileName);
    }
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }


}
