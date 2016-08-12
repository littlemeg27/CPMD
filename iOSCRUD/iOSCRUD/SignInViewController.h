//
//  SignInViewController.h
//  iOSCRUD
//
//  Created by Brenna Pavlinchak on 8/11/16.
//  Copyright © 2016 Brenna Pavlinchak. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <GoogleSignIn/GoogleSignIn.h>

@import Firebase;

@interface SignInViewController : UIViewController <GIDSignInUIDelegate>
{
    
}

@property(weak, nonatomic) IBOutlet GIDSignInButton *signInButton;

@end
