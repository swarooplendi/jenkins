pipeline
{
   agent any
   parameters
   {
    choice(name: 'choice', choices : 'odd\neven\n')
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
              sh'ansible-playbook -e i=${choice} loop.yml'
           }
        }  
     } 
}
        
