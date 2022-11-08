pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        /* CONFIG SERVER */
        stage('Build JAR - configservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('config-service') {
                    bat 'mvn clean install -DskipTests'
                }
            }
        }
        stage('Build Docker Image - configservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('config-service') {
                    bat 'docker build -t grillitoxc/configservice .'
                }
            }
        }
        stage('Push Docker Image - configservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('config-service') {
                    bat 'docker push grillitoxc/configservice'
                }
            }
        }
        /* EUREKA SERVER */
        stage('Build JAR - eurekaservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('eureka-service') {
                    bat 'mvn clean install -DskipTests'
                }
            }
        }
        stage('Build Docker Image - eurekaservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('eureka-service') {
                    bat 'docker build -t grillitoxc/eurekaservice .'
                }
            }
        }
        stage('Push Docker Image - eurekaservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('eureka-service') {
                    bat 'docker push grillitoxc/eurekaservice'
                }
            }
        }
    }
}