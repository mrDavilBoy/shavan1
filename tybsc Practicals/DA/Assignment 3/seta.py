'''import nltk
nltk.download('all')
from nltk.tokenize import sent_tokenize
from nltk.tokenize import word_tokenize

pragraph_text = """Hello all, Welcome to Python Programming Academy. Python Programming Academy is a nice platform to learn new programming skills. It is@ difficult to get! enrolled in& this Academy."""

tokenized_text_data = sent_tokenize(paragraph_text)
tokenized_words = word_tokenize(paragraph_text)
print("Tokenized Sentences : \n",tokenized_text_data,"\n")
print("Tokenized Words : \n",tokenized_words,"\n")'''

import nltk
nltk.download('stopwords')
nltk.download('punkt')

import re
text="""Hello all, Welcome to Python Programming Academy. Python Programming Academy45 is a nice platform to learn new3453 programming skills. It is @ difficult to get! enrolled in & this Academy."""

text = re.sub(r'[[0-9]*]',' ',text)
text = re.sub(r's+',' ',text)

import re
text = re.sub(r'[[0-9]{}*]',' ',text)

formatted_text = re.sub('[^a-zA-Z]',' ',text)
print(formatted_text)


from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize, sent_tokenize
stopWords = set(stopwords.words("english"))
words = word_tokenize(formatted_text)

wordfreq = {} 
for word in words:
   if word in stopWords:
      continue
   if word in wordfreq:
      wordfreq[word]+=1
   else : 
       wordfreq[word] +=1
       
maximum_frequency = max(wordfreq.values())
for word in wordfreq.keys():
    wordfreq[word] = (wordfreq[word]/maximum_frequency)
    
sentences = sent_tokenize(text)
sentenceValue = {}

for sentence in sentences : 
    for word, freq in wordfreq.items():
        if word in sentence.lower():
           if sentence in sentenceValue:
              sentenceValue[sentence]+=freq
           else:
              sentenceValue[sentence]=freq
import heapq
summary = ''
summary_sentence = heapq.nlargest(4,sentenceValue,key=sentenceValue.get)
summary=' '.join(summary_sentences)
print(summary)
