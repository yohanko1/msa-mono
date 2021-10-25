pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'Building apigateway'
            dir(path: 'apigateway') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
          }
        }

        stage('Build') {
          steps {
            echo 'Building configservice'
            dir(path: 'configservice') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
          }
        }
        
        stage('Build') {
          steps {
            echo 'Building productservice'
            dir(path: 'productservice') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
          }
        }
        
        stage('Build') {
          steps {
            echo 'Building registry'
            dir(path: 'registry') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
          }
        }
        
        stage('Build') {
          steps {
            echo 'Building reviewservice'
            dir(path: 'reviewservice') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
          }
        }
      }
    }

    stage('Test') {
      steps {
        echo 'Testing..'
      }
    }

    stage('Deploy') {
      steps {
        echo 'Deploying....'
      }
    }

  }
}
