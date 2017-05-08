package tkh.oracle.storage.OracleCloudStorage;

import java.net.MalformedURLException;

import oracle.cloud.storage.CloudStorage;
import oracle.cloud.storage.CloudStorageConfig;
import oracle.cloud.storage.CloudStorageFactory;

public class CloudSDKClient {
	
	
	private static CloudStorage cloudStorage;
	private static CloudSDKClient cloudSDKClient;
	
	
	
	
	private CloudSDKClient() throws MalformedURLException{
		CloudStorageConfig myConfig = new CloudStorageConfig();
		myConfig.setServiceName("myService-myIdentityDomain")
		.setUsername(" your_registration_email@gmail.com ")
		.setPassword(" your_password ".toCharArray())
		.setServiceUrl("https://storage.us2.oraclecloud.com ");
		cloudStorage = CloudStorageFactory.getStorage(myConfig);
	}
	
	
	public static CloudStorage  getCloudStorageClient() throws Exception{
		
		if(cloudStorage==null){
			createCloudStorageConenction();
		}
		
		return cloudStorage;
		
	}


	private static synchronized void createCloudStorageConenction() throws Exception {
	
		if(cloudStorage==null){
			cloudSDKClient =  new CloudSDKClient();
		}
		
	}
	

}
