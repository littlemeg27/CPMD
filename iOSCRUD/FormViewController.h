//
//  FormViewController.h
//  iOSCRUD
//
//  Created by Brenna Pavlinchak on 8/8/16.
//  Copyright © 2016 Brenna Pavlinchak. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface FormViewController : UIViewController
{
    IBOutlet UITextField *firstNameTextField;
    IBOutlet UITextField *lastNameTextField;
    IBOutlet UITextField *ageNameTextField;
    IBOutlet UIButton *addButton;
}

-(IBAction)addButton:(id)sender;

@end
