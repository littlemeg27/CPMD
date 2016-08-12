//
//  SignInViewController.m
//  iOSCRUD
//
//  Created by Brenna Pavlinchak on 8/11/16.
//  Copyright © 2016 Brenna Pavlinchak. All rights reserved.
//

#import "SignInViewController.h"

@interface SignInViewController ()

@end

@implementation SignInViewController

@synthesize signInButton;


- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    // TODO(developer) Configure the sign-in button look/feel
    
    signInButton = [UIButton buttonWithType:UIButtonTypeRoundedRect]; //Start of the login button
    
    if(signInButton !=nil)
    {
        signInButton.frame = CGRectMake(300.0, 90.0, 110.0, 40.0);
    }
    [self.view addSubview:signInButton];
    
    [GIDSignIn sharedInstance].uiDelegate = self;
    
    //Uncomment to automatically sign in the user.
    [[GIDSignIn sharedInstance] signInSilently];
}

- (void)signIn:(GIDSignIn *)signIn didSignInForUser:(GIDGoogleUser *)user withError:(NSError *)error {
    
    if (error == nil)
    {
        GIDAuthentication *authentication = user.authentication;
        FIRAuthCredential *credential = [FIRGoogleAuthProvider credentialWithIDToken:authentication.idToken
                                         accessToken:authentication.accessToken];
        
        [[FIRAuth auth] signInWithCredential:credential completion:^(FIRUser *user, NSError *error)
         {
             
         }];
    }
    else
    {
        
    }
    

}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
