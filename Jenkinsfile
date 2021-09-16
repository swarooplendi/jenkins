pipeline
{
    agent any
    options 
	{ 
		disableConcurrentBuilds()
		    disableResume()   
	}
    parameters 
	{
        string(name: 'STRING', defaultValue: 'https://gitlab.com/lendiswaroop/assignment1.git', description: 'git url to clone')
	string(name: 'STRING2', defaultValue: 'main', description: 'branch to clone')
        booleanParam(name: 'BOOLEAN', defaultValue: true, description: 'do you want to execute shell')
        choice(name: 'CH', choices: ['1', '2', '3', '4'], description: 'Pick something')
        }

    stages 
	{
        stage('Clean Workspace') 
		{
            steps 
			{
                cleanWs()
                        }
                }
        stage('Git checkout')
		{
            steps 
			{
                sh "mkdir -p lendiswaroop"
              
                     dir('lendiswaroop') {
                        checkout([$class: 'GitSCM', branches: [[name: "$STRING2"]], extensions: [], userRemoteConfigs: [[url: "$STRING" ]]])
                                         }
              }
         }
	
       stage('Execute 1.sh') 
		{
            steps 
			{
                dir('lendiswaroop') {
		 
		sh '''	     if [ "$BOOLEAN" = true ]
             then
             bash -x 1.sh
             else
             echo "user has selected false"
             fi'''
                        
                                   }
                       }    
		
                }
         
         
stage('save log build') 
		{
steps 
			{
script 
				{
def logContent = Jenkins.getInstance()
.getItemByFullName(env.JOB_NAME)
.getBuildByNumber(
Integer.parseInt(env.BUILD_NUMBER))
.logFile.text
// copy the log in the job's own workspace
writeFile file: "buildlog.txt", text: logContent

				}

			}
	          }
		
stage('choice')
		{
            steps 
			{
        sh '''if [ "$CH" = "1" ]
then
echo "you have choosed opion 1"
elif [ "$CH" = "2" ]
then
echo "you have choosed opion 2"
elif [ "$CH" = "3" ]
then
echo "you have choosed opion 3"
else
echo "you have choosed opion 4"
fi'''
                         }
                 }		
            
      }
	
}
