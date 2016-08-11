//
//  DetailViewController.h
//  iOSCRUD
//
//  Created by Brenna Pavlinchak on 8/8/16.
//  Copyright © 2016 Brenna Pavlinchak. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface DetailViewController : UIViewController
{
    IBOutlet UILabel *firstNameLabel;
    IBOutlet UILabel *lastNameLabel;
    IBOutlet UILabel *ageLabel;
    IBOutlet UIButton *deleteButton;
}

@property(nonatomic, copy) NSString* firstName;
@property(nonatomic, copy) NSString* lastName;
@property(nonatomic, copy) NSString* age;

-(void)updateUILabel;
-(IBAction)deleteButton:(id)sender;

@end
