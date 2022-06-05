#!groovy
def call() {
    echo "Welcome"
}


pipeline {
    agent {
        node {
            label 'ubuntu'
        }
    }
    stages {
        stage('Clone Repo Project') {
            steps {
               util()
            }
        }
        
    }
    post {
        success {
            echo "THE END JOB SUCCEEDED!"
        }
        failure {
            echo "FALHA !!! "
        }
        always {
            cleanWs deleteDirs: true, patterns: [[pattern: '', type: 'EXCLUDE']]
        }      
    }       
}