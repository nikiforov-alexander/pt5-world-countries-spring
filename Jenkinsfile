pipeline {
    agent {
        docker { image 'openjdk:8u171-jdk-alpine' }
    }
    stages {
        stage('Build') {
            steps {
                sh 'echo "Build "'
                    sh '''
                    ls -lah
                    ls gradlew
                    ./gradlew.bat -v
                    '''
            }
        }
    }
}

