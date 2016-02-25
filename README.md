LauncherV3
==========

### Dependency setup

Must package and install MinecraftCore, LauncherCore, LauncherUICore first.

```bash
brew install maven
git clone git@github.com:TechnicPack/MinecraftCore.git
git clone git@github.com:TechnicPack/LauncherCore.git
git clone git@github.com:TechnicPack/LauncherUICore.git

# May need to use correct versions
cd LauncherCore
mvn clean package
mvn clean install
cd ..
cd MinecraftCore
mvn clean package
mvn clean install
cd ..
cd LauncherUICore
mvn clean package
mvn clean install
```

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

deploy to S3 bucket into (see example uploads):

exe and jar: launcher/BUILD_NUMBER/
stable4: launcher/version/stable4


### Setting/Updating bitcraft and minecraft versions

Edit ```littlebits.json``` for the latest version, and upload it and the latest to the correct bucket or location.

### Example uploads:

```
# Assuming version 452
aws s3 cp target/launcher-4.0-452.jar s3://littlebits-bitcraft/launcher/452/LittlebitsBitcraft.jar --profile littlebits

aws s3 cp target/launcher-4.0-452.exe s3://littlebits-bitcraft/launcher/452/LittlebitsBitcraft.exe --profile littlebits

aws s3 cp stable4 s3://littlebits-bitcraft/launcher/version/stable4 --profile littlebits

aws s3 cp littlebits.json s3://littlebits-bitcraft/littlebits.json --profile littlebits

aws s3 cp /Users/travis/littlebits/littlebits-bitcraft-0.1.3.zip s3://littlebits-bitcraft/littlebits-bitcraft-0.1.3.zip --profile littlebits

aws s3 cp target/bundles/Littlebits\ Bitcraft-1.0.dmg s3://littlebits-bitcraft/launcher/452/LittlebitsBitcraft.dmg --profile littlebits
```
