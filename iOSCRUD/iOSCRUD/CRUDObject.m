//
//  CRUDObject.m
//  iOSCRUD
//
//  Created by Brenna Pavlinchak on 8/8/16.
//  Copyright © 2016 Brenna Pavlinchak. All rights reserved.
//

#import "CRUDObject.h"

@implementation CRUDObject

@synthesize firstName, lastName, age;

-(id)initWithTitle:(NSString*)firstNameObject crudObject:(NSString *)lastNameObject crudObject:(NSString *)ageObject
{
    if((self = [super init]))
    {
        [self setFirstName:firstNameObject];
        [self setLastName:lastNameObject];
        [self setAge:ageObject];
    }
    return self;
}

@end
