resource "aws_instance" "jenkins" {
  ami                       = data.aws_ami.centos.id
  instance_type             = "t2.micro"
  vpc_security_group_ids    = ["sg-03b7c5e7fe92f2e19"]
  key_name                  = "devops"
  tags                      = {
    Name                    = "Jenkins"
  }
}

resource "null_resource" "jenkins-setup" {

  triggers = {
    sample  = timestamp()
  }

  connection {
    host                    = aws_instance.jenkins.public_ip
    user                    = "centos"
    password                = "DevOps321"
  }

  provisioner "remote-exec" {
    inline                  = [
      "sudo yum install ansible -y",
      "echo localhost >/tmp/hosts",
      "ansible-pull -i /tmp/hosts -U https://rkb03:password@gitlab.com/batch47/jenkins/jenkins-setup.git ansible/setup.yml"
    ]
  }

}

#resource "aws_route53_record" "jenkins" {
#  name                      = "jenkins"
#  type                      = "A"
#  zone_id                   = "Z0645060O3WEMEDWP0JV"
#  ttl                       = 10
#  records                   = [aws_instance.jenkins.public_ip]
#}
