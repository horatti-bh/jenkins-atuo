folder('Terraform') {
    displayName('Terraform')
    description('Terraform_jobs')
}


pipelineJob("Terraform/vpc") {
    description('VPC_job')
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        github("horatti-bh/terraform_vpc.git", "https")
                        credentials("GIT")
                    }
                    branch("*/basic_of_vpc")
                }
            }
            scriptPath("Jenkinsfile")
        }
    }
}