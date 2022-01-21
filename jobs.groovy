folder('Terraform') {
    displayName('Terraform')
    description('Terraform_jobs')
}


job('Terraform/VPC') {
    scm {
        git {
            remote {
                name('GIT')
                url('https://github.com/horatti-bh/terraform_vpc.git')
                credentials('GIT')
            }
            branches('basic_of_vpc')
            extensions {
                cleanAfterCheckout()
            }
        }
    }
}