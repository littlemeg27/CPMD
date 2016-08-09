//
//  CRUDObject.h
//  iOSCRUD
//
//  Created by Brenna Pavlinchak on 8/8/16.
//  Copyright © 2016 Brenna Pavlinchak. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface CRUDObject : NSObject
{
    NSMutableArray *theCRUDList;
}

@property (nonatomic, strong) NSString *firstName;
@property (nonatomic, strong) NSString *lastName;
@property (nonatomic, strong) NSString *age;

-(id)initWithTitle:(NSString*)firstNameObject crudObject:(NSString*)lastNameObject crudObject:(NSString*)ageObject;

@end
