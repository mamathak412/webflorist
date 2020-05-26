pipeline {
    agent any
    tools {
     maven 'jenkins_maven'
     jdk 'jdk8'
      }
  
  environment {
    registry = "mamathak412/webflorist1-latest"
    registryCredential = 'dockerhub'
    dockerImage = ''
  }
  
    stages {
        
        stage('Checkout'){
            steps{
                echo "Clear workspace"
               deleteDir()
                 checkout([$class: 'GitSCM', 
             branches: [[name: '*/master']], 
             doGenerateSubmoduleConfigurations: false, 
             extensions: [[$class: 'CleanCheckout']], 
             submoduleCfg: [], 
            userRemoteConfigs: [[credentialsId: 'githubId', url: 'https://github.com/mamathak412/webflorist.git']]
])
            }
        }
        stage('Build') {
            steps{
              configFileProvider([configFile(fileId: 'c363e7f8-6378-4df9-8229-d9b034af6a1d', variable: 'MAVEN_SETTINGS')]) {
                    sh 'mvn -s $MAVEN_SETTINGS clean install -U'
                }
            }
        }
        
        stage('Test'){
            steps{
              configFileProvider([configFile(fileId: 'c363e7f8-6378-4df9-8229-d9b034af6a1d', variable: 'MAVEN_SETTINGS')]) {
                    sh 'mvn -s $MAVEN_SETTINGS test'
                }
            }
        }
        
      /*    stage('Sonar integeration'){
            steps{
                    withSonarQubeEnv('jenkins_sonar') {
                sh 'mvn clean package sonar:sonar'
              }
            }
        } */
        
        stage('Building image'){
        	 steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
        }
        
         stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( 'https://registry.hub.docker.com', registryCredential ) {
            dockerImage.push()
          }
        }
      }
    }
    
    stage('Remove Unused docker image') {
      steps{
        sh "docker rmi $registry:$BUILD_NUMBER"
      }
    }
      
      
    }
}