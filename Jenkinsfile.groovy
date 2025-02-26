#!/usr/bin/env groovy

pipeline {
    agent any
    stages {
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