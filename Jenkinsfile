pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/GitAllStarA/The-Daily-Byte.git'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t my-app-dailyByte:latest .'
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                withKubeConfig([credentialsId: 'local-k8s-config']) {
                    sh 'kubectl get nodes'
                    sh 'kubectl apply -f k8s/deployment.yaml'
                }
            }
        }
    }
}
