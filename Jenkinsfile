node {

  echo 'Preparation'
  env.PATH = "${tool 'M3'}/bin:${env.PATH}"
  sh "git config --global user.name \"--- Insert your user name ---\""
  sh "git config --global user.email your_email@example.com"
  sh "git config --global credential.helper cache"

  sh "rm -rf *"
  sh "rm -rf .git"
  checkout scm
  sh "git checkout $BRANCH_NAME"
  
  stage 'Set version'
  if (env.BRANCH_NAME == 'develop') {
     sh "git checkout develop2"
     sh "git pull origin develop2"

     def buildnumber = readFile('current.tag').trim();
     echo 'current.tag has: ' + buildnumber;
     def buildnumberNext = (buildnumber.toInteger() + 1).toString();
     writeFile file: 'current.tag', text: buildnumberNext;
     sh "git add current.tag"
     sh "git commit -m \"Build $buildnumberNext\""
     sh "git push origin develop2"

     // Read version from pom.xml
     sh "git checkout develop"
     def pom = readMavenPom file: 'pom.xml';
     def originalVersion = pom.version;
     echo 'Original version: ' + originalVersion;

     def v = originalVersion.tokenize(".-");
     def newVersion = v[0] + "." + v[1] + "." + buildnumberNext;
     if (v.size() == 4) {
       newVersion += "-" + v[3];
     }
     echo 'New version: ' + newVersion;
	 
     sh "mvn -B versions:set -DgenerateBackupPoms=false -DnewVersion=" + newVersion
  }

  stage 'Build and Test'
  sh "mvn clean package"
}
