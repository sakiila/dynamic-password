# Dypa

Dypa (IPA: /ˈdaɪpɑ/) for Dynamic Password, help people to remember passwords easily, protect them safely.
> Even if your password released this time, but they can't log in successfully next time.

# Introduction

As of now, there are tons of accounts and passwords that one person should remember for Internet services,
so, the more the same password is used, the more accounts can be hacked.
Also, the more different passwords had to be set, the more the "Forget Password" button will be clicked.

This program is designed for those who want to remember their passwords, and don't like the Password Managers
Applications.

# Use

### how to use

run the java class `Main.matchWithBracket(template, inputPassword)`, return the `inputPassword` is or not correct.

### user case

Password Template: `{year}On{month(+1)}Take{minute(/2)}`  
(For remember: this year On next month Take half of the minute)  
Real Password: `2022On10Take15`  
(time now is 2022-09-01 07:30:00)

# Future Features

- [ ] support 'not' syntax
- [ ] support fuzzy matching
- [ ] support template with custom text
- [ ] support more math operations (like cos, sin)
- [ ] support other languages (like python)

# License

Dypa is released under the Apache License Version 2, which is an open source license. You may contribute to this
project, or use the code as you please as long as you adhere to its conditions. You can find a copy of the license text
within LICENSE.