package com.registro.usuarios.services;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import org.springframework.stereotype.Service;

import com.google.cloud.spring.storage.GoogleStorageResource;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;


@Service
public class CloudStorageServices {
	
	  @Value("${gcs-resource-test-bucket}")
	  private String bucketName;
	  
	  @Autowired
	  private Storage storage;
	  
	  
	  public GoogleStorageResource fetchResource(String filename) {
	    return new GoogleStorageResource(
	        this.storage,filename);
	  }
	  
	  public void uploadObject(String objectName, Resource resource) throws IOException {
		    BlobId blobId = BlobId.of(bucketName, objectName);
		    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("application/pdf").build();

		    Storage.BlobWriteOption precondition;
		    if (this.storage.get(bucketName, objectName) == null) {
		      precondition = Storage.BlobWriteOption.doesNotExist();
		    } else {
		      precondition =
		          Storage.BlobWriteOption.generationMatch(
		              storage.get(bucketName, objectName).getGeneration());
		    }
		    this.storage.createFrom(blobInfo, resource.getInputStream(), precondition);
		  }
	}