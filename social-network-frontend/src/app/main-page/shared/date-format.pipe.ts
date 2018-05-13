import {Pipe, PipeTransform} from '@angular/core';
import * as moment from 'moment';

@Pipe({
  name: 'dateFormat'
})
export class DateFormatPipe implements PipeTransform {

  transform(value: any, toFormat?: any, fromFormat?: any): any {
    if (value) {
      return fromFormat ? moment(value, fromFormat).format(toFormat) : moment(value).format(toFormat);
    }
    return value;
  }

}
