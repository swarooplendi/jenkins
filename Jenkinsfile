pipeline {
    agent any
    options { disableConcurrentBuilds()
		    timeout(time: 1, unit: 'HOURS')
		    disableResume() 
    }
    parameters {
        string(name: 'STRING_VARIABLE', defaultValue: 'TestTrainer', description: 'Who should I say hello to?')
        text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')
        booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')
        choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
        password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
    }
    environment {
        def name = "my name"
        def pwdv = ""
        def gitavUrl = 'https://gitlab.com/ashvaish/assignment.git'
        def gitavBranch = 'main'
        def gitswUrl = 'https://gitlab.com/lendiswaroop/assignment1.git'
        def gitswBranch = 'main'        
    } 
    stages {
        stage('Clean Workspace') {
            steps {
                cleanWs()
            }
        }
        stage('Git checkout') {
            steps {
                sh "mkdir -p deps/ashvaish deps/lendiswaroop"
                dir('deps') {
                    dir('ashvaish') {
                        checkout([$class: 'GitSCM', branches: [[name: "$gitavBranch"]], extensions: [], userRemoteConfigs: [[url: "$gitavUrl" ]]])
                    }
                }
                dir('deps') {
                    dir('lendiswaroop') {
                        checkout([$class: 'GitSCM', branches: [[name: "$gitswBranch"]], extensions: [], userRemoteConfigs: [[url: "$gitswUrl" ]]])
                    }
                }                
            }
        }
        stage('Execute 1.sh') {
            steps {
                dir('deps') {
                    dir('lendiswaroop') {
                        timestamps {
                            sh("bash -x 1.sh")
                        }
                    }
                }
            }          
        }
        stage('Confirm button') {
            steps {
                input 'Please confirm'
                //sh("echo asdasdasd")
            }
        }        
        stage('File write') {
            steps {
                dir('deps') {
                    dir('ashvaish') {
                        writeFile file: 'test-write-file', text: 'asdasdasdasdasd'
                    }
                }
            }
        }        
        /*stage('Delete Directory') {
            steps {
                dir('deps') {
                    dir('ashvaish') {
                        deleteDir()
                    }
                }
            }
        } */       
    }
}
