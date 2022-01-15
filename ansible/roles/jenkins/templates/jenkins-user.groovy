#!groovy

import jenkins.model.*
import hudson.security.*
import hudson.util.*;
import jenkins.install.*;

def instance = Jenkins.getInstance()

println "--> creating local user 'jenkins'"

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount('jenkins','jenkins')
instance.setSecurityRealm(hudsonRealm)

//def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
//instance.setAuthorizationStrategy(strategy)
instance.setInstallState(InstallState.INITIAL_SETUP_COMPLETED)

instance.save()