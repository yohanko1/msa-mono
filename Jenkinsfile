pipeline {
  agent any
  environment {
  
  }
  
  stages {
    stage('Build') {
      parallel {
        stage('Build apigateway') {
          steps {
            dir(path: 'apigateway') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
          }
        }
        stage('Build configservice') {
          steps {
            dir(path: 'configservice') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
          }
        }
        stage('Build productservice') {
          steps {
            dir(path: 'productservice') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
          }
        }
        stage('Build registry') {
          steps {
            dir(path: 'registry') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
          }
        }
        stage('Build reviewservice') {
          steps {
            dir(path: 'reviewservice') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
          }
        }
      }
    }

    stage('Test') {
      parallel {
        stage('apigateway') {
          steps {
            dir('$STAGE_NAME') {
              sh 'chmod +x ./gradlew'
              sh './gradlew test'
            }
          }
        }
        stage('configservice') {
          steps {
            dir('$STAGE_NAME') {
              sh 'chmod +x ./gradlew'
              sh './gradlew test'
            }
          }
        }
        stage('productservice') {
          steps {
            dir('$STAGE_NAME') {
              sh 'chmod +x ./gradlew'
              sh './gradlew test'
            }
          }
        }
        stage('registry') {
          steps {
            dir('$STAGE_NAME') {
              sh 'chmod +x ./gradlew'
              sh './gradlew test'
            }
          }
        }
        stage('reviewservice') {
          steps {
            dir('$STAGE_NAME') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
          }
        }
      }
    }
    
    stage('Push Docker image') {
      parallel
      steps {
        dir('$STAGE_NAME') {
          dockerImage = docker.build()
          dockerImage.push("yohanko1/$STAGE_NAME")
        }
      }
    }
    
    stage('Docker push') {
      parallel {
        stage('apigateway') {
          steps {
            dir('$STAGE_NAME') {
              dockerImage = docker.build()
              dockerImage.push("yohanko1/$STAGE_NAME")
            }
          }
        }
        stage('configservice') {
          steps {
            dir('$STAGE_NAME') {
              
            }
          }
        }
        stage('productservice') {
          steps {
            dir('$STAGE_NAME') {
            }
          }
        }
        stage('registry') {
          steps {
            dir('$STAGE_NAME') {
            }
          }
        }
        stage('reviewservice') {
          steps {
            dir('$STAGE_NAME') {
            }
          }
        }
      }
    }

    stage('Deploy') {
      steps {
        sh 'docker-compose up -d'
      }
    }
  }
}
