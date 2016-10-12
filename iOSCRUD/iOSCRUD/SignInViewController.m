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

- (void)viewDidLoad {
    
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    printf("Beginiging viewDidLoad\n");
    
    // TODO(developer) Configure the sign-in button look/feel
    
    [GIDSignIn sharedInstance].uiDelegate = self;
    
    //Uncomment to automatically sign in the user.
//    [[GIDSignIn sharedInstance] signInSilently];
    
    printf("End viewDidLoad\n");
}

- (void)signIn:(GIDSignIn *)signIn didSignInForUser:(GIDGoogleUser *)user withError:(NSError *)error {
    
    if (error == nil)
    {
        GIDAuthentication *authentication = user.authentication;
        FIRAuthCredential *credential = [FIRGoogleAuthProvider credentialWithIDToken:authentication.idToken
                                         accessToken:authentication.accessToken];
        printf("Inside signIn\n");
        
        [[FIRAuth auth] signInWithCredential:credential completion:^(FIRUser *user, NSError *error)
         {
             printf("Inside signInWithCredential\n");
         }];
    }
    else
    {
        
    }
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
