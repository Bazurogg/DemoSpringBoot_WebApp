#!/usr/bin/env groovy

pipeline {
    agent any
    environment {
        //nom de l'image pour le docker Hub
        registry = "bazurogg/webspringboot2025"
        // compte Docker paramétré sur le serveur Jenkins
        // dans la rubrique Credentials de l'administration serveur
        registryCredential = 'DockerHubAccount'
        dockerImage = ''
    }

    stages {

        stage('Clean workspace') {
            steps {
                cleanWs()
            }
        }

        stage('Git Checkout - WebApp') {
            steps {
                script {
                    git branch: 'master',
                        credentialsId: 'Github Classic Token',
                        url: 'https://github.com/Bazurogg/DemoSpringBoot_WebApp'
                }
            }
        }

        stage('Git Checkout - API') {
            steps {
                script {
                    git branch: 'master',
                            credentialsId: 'Github Classic Token',
                            url: 'https://github.com/Bazurogg/DemoSpringBoot_API'
                }
            }
        }

        stage('Build Maven - WebApp') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image - WebApp') {
            steps {
                script {
                    docker.build('bazurogg/webspringboot2025:latest', '-f Dockerfile .')
                }
            }
        }

        stage('Build Docker Image - API') {
            steps {
                script {
                    docker.build('bazurogg/apispringboot2025:latest', '-f Dockerfile .')
                }
            }
        }

        // push de l'image dans le dockerHub
        stage('Push to Docker Hub - WebApp') {
            steps {
                script {
                    // interaction avec un registre Docker
                    // '' registre par défaut
                    // "registryCredentials" identifiant des informations d'identification stockées dans Jenkins pour accéder à Docker Hub
                     docker.withRegistry('', registryCredential) {
                         //".push()" Envoie de l'image Docker vers le registre spécifié
                        docker.image('bazurogg/webspringboot2025:latest').push()
                    }
                }
            }
        }

        stage('Push to Docker Hub - API') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        docker.image('bazurogg/springbootapi2025:latest').push()
                    }
                }
            }
        }

        // déploiement du multi container avec docker compose
        stage('Deploy with Docker Compose') {
            steps {
                // initialise le conteneur docker
                script {
                    // construit les services
                    bat 'docker-compose up -d --build --force-recreate --remove-orphans'
                }
            }
        }

    }

}