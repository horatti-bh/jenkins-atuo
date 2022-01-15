data "aws_ami" "centos" {
  most_recent      = true
  name_regex       = "^Centos*"
  owners           = ["973714476881"]
}

