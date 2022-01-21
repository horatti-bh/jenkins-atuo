folder('Terraform') {
    displayName('Terraform')
    description('Terraform_jobs')
}


job('VPC') {
    scm {
        git {
            remote {
                name('GIT')
                url('https://github.com/horatti-bh/terraform_vpc.git')
                credentials('GIT')
            }
            extensions {
                cleanAfterCheckout()
            }
        }
    }
}