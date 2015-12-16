LauncherV3
==========

### Building

Set the next build number:
```bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/
BUILD_NUMBER= mvn clean package 
BUILD_NUMBER= mvn clean package -P package-win
```

#### Troubleshooting builds:
get a message about file already exists?
unmount all DMGs


### Deploying

Edit ```stable4``` with the BUILD_NUMBER from before.

deploy to S3 bucket into:

exe and jar: launcher/BUILD_NUMBER/

stable4: auncher/version/stable4



### Setting up bitcraft versions

Edit ```littlebits.json``` for the latest version, and upload it and the latest to the correct bucket or location.
