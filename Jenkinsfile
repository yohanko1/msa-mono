pipeline {
  agent any
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
            dir(path: 'apigateway') {
              sh 'chmod +x ./gradlew'
              sh './gradlew test'
            }
          }
        }
        stage('configservice') {
          steps {
            dir(path: 'configservice') {
              sh 'chmod +x ./gradlew'
              sh './gradlew test'
            }
          }
        }
        stage('productservice') {
          steps {
            dir(path: 'productservice') {
              sh 'chmod +x ./gradlew'
              sh './gradlew test'
            }
          }
        }
        stage('registry') {
          steps {
            dir(path: 'registry') {
              sh 'chmod +x ./gradlew'
              sh './gradlew test'
            }
          }
        }
        stage('reviewservice') {
          steps {
            dir(path: 'reviewservice') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
          }
        }
      }
    }

    stage('Docker push') {
      parallel {
        stage('apigateway') {
          steps {
            dir(path: "$STAGE_NAME") {
              script {
                docker.withRegistry('', 'yohanko1-dockerhub') {
                  def dockerImage = docker.build("yohanko1/$STAGE_NAME")
                  dockerImage.push()                    
                }
              }
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
        sh 'curl -L https://github.com/docker/compose/releases/download/1.8.0/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose'
        sh 'docker-compose up -d'
      }
    }
  }
}
