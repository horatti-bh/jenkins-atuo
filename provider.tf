provider "aws" {
  region            = "us-east-1"
}

#terraform {
#  backend "s3" {
#    bucket          = "terraform-states"
#    key             = "jenkins/terraform.tfstate"
#    region          = "us-east-1"
#    dynamodb_table  = "terraform"
#  }
#}
