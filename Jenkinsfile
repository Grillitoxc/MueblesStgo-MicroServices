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
        /* GATEWAY SERVER */
        stage('Build JAR - gatewayservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('gateway-service') {
                    bat 'mvn clean install -DskipTests'
                }
            }
        }
        stage('Build Docker Image - gatewayservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('gateway-service') {
                    bat 'docker build -t grillitoxc/gatewayservice .'
                }
            }
        }
        stage('Push Docker Image - gatewayservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('gateway-service') {
                    bat 'docker push grillitoxc/gatewayservice'
                }
            }
        }
        /* EMPLOYEE SERVICE */
        stage('Build JAR - employeeservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('employee-service') {
                    bat 'mvn clean install -DskipTests'
                }
            }
        }
        stage('Build Docker Image - employeeservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('employee-service') {
                    bat 'docker build -t grillitoxc/employeeservice .'
                }
            }
        }
        stage('Push Docker Image - employeeservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('employee-service') {
                    bat 'docker push grillitoxc/employeeservice'
                }
            }
        }
        /* EXTRAHOURS SERVICE */
        stage('Build JAR - extrahoursservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('extrahours-service') {
                    bat 'mvn clean install -DskipTests'
                }
            }
        }
        stage('Build Docker Image - extrahoursservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('extrahours-service') {
                    bat 'docker build -t grillitoxc/extrahoursservice .'
                }
            }
        }
        stage('Push Docker Image - extrahoursservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('extrahours-service') {
                    bat 'docker push grillitoxc/extrahoursservice'
                }
            }
        }
        /* JUSTIFIER */
        stage('Build JAR - justifierservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('justifier-service') {
                    bat 'mvn clean install -DskipTests'
                }
            }
        }
        stage('Build Docker Image - justifierservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('justifier-service') {
                    bat 'docker build -t grillitoxc/justifierservice .'
                }
            }
        }
        stage('Push Docker Image - justifierservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('justifier-service') {
                    bat 'docker push grillitoxc/justifierservice'
                }
            }
        }
        /* CLOCK SERVICE */
        stage('Build JAR - clockservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('clock-service') {
                    bat 'mvn clean install -DskipTests'
                }
            }
        }
        stage('Build Docker Image - clockservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('clock-service') {
                    bat 'docker build -t grillitoxc/clockservice .'
                }
            }
        }
        stage('Push Docker Image - clockservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('clock-service') {
                    bat 'docker push grillitoxc/clockservice'
                }
            }
        }
        /* SPREADSHEET SERVICE */
        stage('Build JAR - spreadsheetservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('spreadsheet-service') {
                    bat 'mvn clean install -DskipTests'
                }
            }
        }
        stage('Build Docker Image - spreadsheetservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('spreadsheet-service') {
                    bat 'docker build -t grillitoxc/spreadsheetservice .'
                }
            }
        }
        stage('Push Docker Image - spreadsheetservice') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Grillitoxc/MueblesStgo-MicroServices']]])
                dir('spreadsheet-service') {
                    bat 'docker push grillitoxc/spreadsheetservice'
                }
            }
        }
    }
}