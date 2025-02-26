#!/usr/bin/env groovy

pipeline {
    agent any
    stages {
        stage('Clean workspace') {
            steps {
                cleanWs()
            }
        }
        stage('Git Checkout') {
            steps {
                script {
                    git branch: 'master',
                        credentialsId: 'Github Classic Token',
                        url: 'https://github.com/Bazurogg/DemoSpringBoot_WebApp'
                }
            }
        }
    }
}