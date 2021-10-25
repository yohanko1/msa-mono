pipeline {
    agent any
    triggers {
        githubPush()
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh './graldew build'
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
