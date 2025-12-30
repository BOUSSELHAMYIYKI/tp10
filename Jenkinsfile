pipeline {
    agent any

    environment {
        IMAGE_NAME = "tp3-java-app:latest"
        CONTAINER_NAME = "tp3-java-container"
        HOST_PORT = "8081"
        CONTAINER_PORT = "8081"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/BOUSSELHAMYIYKI/testttttttttt.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn -B clean package -DskipTests'
            }
        }

    stage('Test') {
       steps {
           sh 'mvn clean test -B -DfailIfNoTests=false'
       }
       post {
           always {
               junit '**/target/surefire-reports/*.xml'
           }
       }
   }


        stage('Docker Build') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Deploy (Local Docker)') {
            steps {
                sh '''
                # Stoppe le container s'il existe
                docker stop $CONTAINER_NAME || true
                docker rm $CONTAINER_NAME || true

                # Lancer le container en arrière-plan
                docker run -d \
                    --name $CONTAINER_NAME \
                    -p ${HOST_PORT}:${CONTAINER_PORT} \
                    $IMAGE_NAME
                '''
            }
        }
    }

    post {
        success {
            echo "✅ Pipeline completed and deployment finished successfully!"
        }
        failure {
            echo "❌ Pipeline failed!"
        }
    }
}
