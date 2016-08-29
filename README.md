# Woocommerce Android Client (Unofficial )

![Image of Yaktocat](https://octodex.github.com/images/yaktocat.png)

A beta Woocommerce Client for Android. Till now it has been very difficult to create Android Apps using Woocommerce as a backend. With the advent of the Woocommerce Rest API, the Woocommerce team has given the developers a quick and easy way to interact with the world's most popular ecommerce plugin for Wordpress. This library helps in easing things out even further. Don't take my word for it. Just take it for a spin and you will know. 

# How To Use

1. In your module level/app level build.gradle file, add the following lines

        repositories {
            jcenter()
    
            maven {
                url "https://jitpack.io"
            }   
        }
    
2. Then in dependencies, add the following line to include the library:
  
        dependencies {
            .
            .
            compile 'com.github.rajatady:Woocommerce-Android-Client:0.0.3'
        }
3. Sync the project with the gradle files. The library should be imported to your project.
4. Create a new Java Class which extends the Application Class or if you already have one created, just put the following lines in there.
    
        public class Aadira extends Application {

                @Override
                public void onCreate() {
                    super.onCreate();
        
                    .
                    .
                    .
                    
                    WCBuilder builder = new WCBuilder();
                    
                    //Whether your website has https
                    builder.setIsHttps(false); 
                    
                    // Set the website URL
                    builder.setBaseUrl("your.websiteurl.here");
                    
                    // Signing method. Can be one of HMACSHA1 or HMACSHA256
                    builder.setSigning_method(SigningMethod.HMACSHA1);
                    
                    // your woocommerce api key
                    builder.setWc_key("key here");
                    
                    // your woocommerce api secret
                    builder.setWc_secret("secret here");
                    
                    WooCommerce.getInstance().initialize(builder);
                    .
                    .
                }
        }
    
5. Just get an instance of the Woocommerce Class hereon like this
      
        
        WooCommerce wooCommerce = WooCommerce.getInstance();







