package mindMaster.Training;

import java.io.File;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class fileupload {

	public static void main(String[] args) {

		String BucketName ="trainingbucket1996";

		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new ProfileCredentialsProvider())
                .withRegion("ap-south-1")
                .build();
		
		
		PutObjectRequest putobject = new PutObjectRequest(BucketName,"myfolder/22/09", new File("C:\\Users\\jadavsuresh\\Desktop\\sampledata.txt"));
		ObjectMetadata meta = new ObjectMetadata();
		
		meta.setContentType("plain/text");
		meta.addUserMetadata("sureshKey", "suresh");
		putobject.setMetadata(meta);
		
		
		s3Client.putObject(putobject);
		
		

	}

}
