package mindMaster.Training;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.RegionUtils;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
   
    	String BucketName ="trainingbucket1996";
    	
    	
    //	Region  region = RegionUtils.getRegion("ap-south-1");                                                        
   
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new ProfileCredentialsProvider())
                .withRegion("ap-south-1")
                .build();
    	
		
		if(s3Client.doesBucketExist(BucketName)){
			System.out.println("s3 bucket  exit");
		}
		else
		{
			// bucket creation
			s3Client.createBucket(BucketName);
		}
    	
    	
    }
}
