// Imports the required libraries.
const fs      = require('fs');
const parser  = require('mailparser').simpleParser;
const Mbox    = require('node-mbox');

// Defines some constants.
const defaultFilePath = './problems.mbox';
const defaultSubjectPrefix = 'Daily Coding Problem: Problem #';
const defaultPaddingLength = 3;

// Checks whether the file exists.
if (!fs.existsSync(defaultFilePath)) {
    console.log(`Cannot find any file at expected path of ${defaultFilePath}. Please check.`);
    return;
}

// Parses the given .mbox file.
const mbox = new Mbox(defaultFilePath);
mbox.on('message', msg => {
    // Parses the given raw email message.
    parser(msg).then(mail => {
        // Checks the subject.
        const subject = mail.headers.get('subject');
        if (subject === undefined || !subject.startsWith(defaultSubjectPrefix)) {
            console.log(`${subject} is not in standard format. Will skip.`);
            return;
        }
        const title = subject.slice(defaultSubjectPrefix.length);

        // Extracts the index number.
        const matchID = /\d+/.exec(title);
        if (matchID === null || matchID.length === 0) {
            console.log(`Cannot find question ID from ${subject}.`);
            return;
        }
        const questionID = matchID[0].padStart(defaultPaddingLength, '0');

        // Extracts the difficulty level;
        const matchLevel = /(Easy|Medium|Hard)/.exec(title);
        let questionLevel = 'Unknown';
        if (matchLevel !== null && matchLevel.length > 0) {
            questionLevel = matchLevel[0];
        }

        const fileName = `../questions/${questionID}.html`;
        fs.writeFile(fileName, mail.html, err => {
            if (err) {
                console.log(`Unable to save the content to ${fileName} due to ${err}.`);
                return;
            }
            console.log(`The question has been saved to ${fileName}.`);
        });
    }).catch(err => {
        console.log('Unable to parse the given mail due to err: ', err);
    });
});
