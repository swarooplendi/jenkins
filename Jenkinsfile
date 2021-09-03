pipeline
{
   agent any
   parameters
   {
    choice(name: 'choice', choices : 'odd\n even\n')
   }
   stages
   {
     stage('pull from git')
      {
       steps
         { 
          git credentialsId: 'git_credential', url: 'https://github.com/swarooplendi/ansible.git'
         }
       }
      stage('run ansible')
       {
         steps
           {
            ansiblePlaybook extras: 'i=${choice}', installation: 'Ansible', playbook: 'loop.yml'
           }
        }  
     } 
}
        
