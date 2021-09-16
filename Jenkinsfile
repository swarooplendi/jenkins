pipeline {
    agent any
    options { disableConcurrentBuilds()
		    timeout(time: 1, unit: 'HOURS')
		    disableResume() 
    }
    parameters {
        string(name: 'STRING', defaultValue: 'https://gitlab.com/lendiswaroop/assignment1.git', description: 'git url to clone')
	string(name: 'STRING2', defaultValue: 'main', description: 'branch to clone')
        booleanParam(name: 'BOOLEAN', defaultValue: true, description: 'do you want to execute shell')
        choice(name: 'CHOICE', choices: ['1', '2', '3', '4'], description: 'Pick something')
        password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
    }
  /*  environment {
        def name = "my name"
        def pwdv = ""
        def gitavUrl = 'https://gitlab.com/ashvaish/assignment.git'
        def gitavBranch = 'main'
        def gitswUrl = 'https://gitlab.com/lendiswaroop/assignment1.git'
        def gitswBranch = 'main'        
    } */
    stages {
        stage('Clean Workspace') {
            steps {
                cleanWs()
            }
        }
        stage('Git checkout') {
            steps {
                sh "mkdir -p lendiswaroop"
              
                     dir('lendiswaroop') {
                        checkout([$class: 'GitSCM', branches: [[name: "$STRING2"]], extensions: [], userRemoteConfigs: [[url: "$STRING" ]]])
                    }
                  }
        }
        stage('Execute 1.sh') {
            steps {
                dir('lendiswaroop') {
		 sh(returnStdout: true, script: '''#!/bin/bash
            if [ "$BOOLEAN" = true ]
then
bash -x 1.sh
else
echo "user has selected false"
fi

 if [ "$CHOICE" = "1" ]
then
echo "you have choosed opion a"
elif [ "$CHOICE" = "2" ]
then
echo "you have choosed opion b"
elif [ "$CHOICE" = "3" ]
then
echo "you have choosed opion c"
else
echo "you have choosed opion d"
fi
     
        '''.stripIndent())
                        
                    }
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
